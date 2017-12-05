package de.heidelberg.pvs.diego.collectionswitch.context.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Set;

import de.heidelberg.pvs.diego.collectionswitch.context.SetAllocationContext;
import de.heidelberg.pvs.diego.collectionswitch.context.SetAllocationContextInfo;
import de.heidelberg.pvs.diego.collectionswitch.context.SetCollectionType;

public class LogSetAllocationContext implements SetAllocationContext {
	
	private static final int FREQUENCY = 10;

	SetAllocationContextInfo context;
	
	PrintWriter writer;
	
	int count = 0;
	
	public LogSetAllocationContext(SetAllocationContextInfo context, String identifier, String dir) {
		super();
		this.context = context;
		long currentTimeMillis = System.currentTimeMillis();
		
		try{
			writer = new PrintWriter(dir + "/" + identifier + "__-__" + currentTimeMillis + ".txt", "UTF-8");
		    writer.println("Context initialized");
		    writer.println("Collecton Type: " + this.context.getCurrentCollectionType());
		    writer.flush();
		} catch (IOException e) {
			if(writer != null) {
				writer.close();
			}
		   // do something
		}
	}

	
	@Override
	public <E> Set<E> createSet() {
		logSetCreation();
		return context.createSet();
	}


	private void logSetCreation() {
		count++;
		if(count % FREQUENCY == 0) {
			writer.println(String.format("Created %d sets", count ));
			writer.flush();
		}
		
	}


	@Override
	public <E> Set<E> createSet(int initialCapacity) {
		logSetCreation();
		return context.createSet(initialCapacity);
	}


	@Override
	public <E> Set<E> createSet(Collection<? extends E> set) {
		logSetCreation();
		return context.createSet(set);
	}


	@Override
	public void updateCollectionType(SetCollectionType type) {
		String beforeState = context.getCurrentCollectionType();
		context.updateCollectionType(type);
		String afterState = context.getCurrentCollectionType();
		
		writer.println("Type updated from " + beforeState + " -- to --" + afterState);
		writer.flush();		
	}

	

	
	

}
