package de.heidelberg.pvs.diego.collections_online_adapter.monitors.sets;

import java.lang.ref.WeakReference;

public class SetState {
	
	private int size;
	private int containsOp;
	private int iterationOp;
	
	private WeakReference<?> setReference;
	
	public SetState(WeakReference<?> map) {
		super();
		this.setReference = map;
	}

	public boolean hasCollectionFinished() {
		return setReference == null;
	}
	
	public int getSize() {
		return size;
	}

	public int getContainsOp() {
		return containsOp;
	}

	public int getIterationOp() {
		return iterationOp;
	}
	
	public void updateSize(int delta) {
		size += delta;
	}
	
	public void updateContainsOp(int delta) {
		containsOp += delta;
	}
	
	public void updateIteration(int delta) {
		iterationOp += delta;
	}

}
