package de.heidelberg.pvs.diego.collections_online_adapter.monitors.maps;

import java.lang.ref.WeakReference;

public class MapState {
	
	private int size;
	private int containsOp;
	private int iterationOp;
	
	private WeakReference<?> mapReference;
	
	public MapState(WeakReference<?> map) {
		super();
		this.mapReference = map;
	}

	public boolean hasCollectionFinished() {
		return mapReference.get() == null;
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
