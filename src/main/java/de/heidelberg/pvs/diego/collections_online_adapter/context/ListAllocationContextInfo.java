package de.heidelberg.pvs.diego.collections_online_adapter.context;

public interface ListAllocationContextInfo extends ListAllocationContext {
	
	public ListCollectionType getCurrentCollectionType();
	

	public int getAnalyzedInitialCapacity();

}
