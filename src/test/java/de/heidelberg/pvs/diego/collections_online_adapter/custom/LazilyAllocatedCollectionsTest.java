package de.heidelberg.pvs.diego.collections_online_adapter.custom;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.diego.collections_online_adapter.context.CollectionTypeEnum;
import de.heidelberg.pvs.diego.collections_online_adapter.factories.AllocationContextFactory;

public class LazilyAllocatedCollectionsTest {

	@Test
	public void testMemotyFootprint() throws Exception {

		// Write to the file
		String footprint = String.format("Lazily Footprint\n%s", GraphLayout
				.parseInstance(new LazyLinkedList()).toFootprint());
		
		System.out.println(String.format("%s", footprint));
		
		footprint = String.format("LinkedList Footprint\n%s", GraphLayout
				.parseInstance(new LinkedList()).toFootprint());

		System.out.println(String.format("%s", footprint));
		
		
		footprint = String.format("ArrayList Footprint\n%s", GraphLayout
				.parseInstance(new ArrayList()).toFootprint());

		System.out.println(String.format("%s", footprint));
		
		footprint = String.format("ArrayList Footprint\n%s", GraphLayout
				.parseInstance(new ArrayList(0)).toFootprint());
		
		System.out.println(String.format("%s", footprint));
		
		footprint = String.format("LazyArrayList Footprint\n%s", GraphLayout
				.parseInstance(new LazyArrayList()).toFootprint());

		System.out.println(String.format("%s", footprint));

	}

}
