package de.heidelberg.pvs.diego.collectionswitch.optimizers.lists;

import java.util.List;

import de.heidelberg.pvs.diego.collectionswitch.context.ListAllocationContext;
import de.heidelberg.pvs.diego.collectionswitch.optimizers.AllocationOptimizer;

import se.lth.util.*;

public interface ListAllocationOptimizer extends AllocationOptimizer {

        public <E> List<E> createMonitor(List<E> monitor);

        public void setContext(ListAllocationContext context);

    public <E> List<E> createArrayListInterfaceMonitor(ArrayListInterface<E> list);

    public <E> List<E> createLinkedListInterfaceMonitor(LinkedListInterface<E> list);

    public <E> List<E> createVectorInterfaceMonitor(VectorInterface<E> list);
}
