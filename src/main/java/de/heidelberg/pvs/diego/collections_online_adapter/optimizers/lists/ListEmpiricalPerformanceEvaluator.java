package de.heidelberg.pvs.diego.collections_online_adapter.optimizers.lists;

import java.util.List;
import java.util.Map;

import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;

import de.heidelberg.pvs.diego.collections_online_adapter.context.ListCollectionType;
import de.heidelberg.pvs.diego.collections_online_adapter.manager.PerformanceGoal.PerformanceDimension;
import de.heidelberg.pvs.diego.collections_online_adapter.monitors.lists.ListMetrics;

public class ListEmpiricalPerformanceEvaluator {

	private static Map<PerformanceDimension, List<ListPerformanceModel>> listEmpiricalModel = new UnifiedMap<>();

	public static void addEmpiricalModel(PerformanceDimension dimension, List<ListPerformanceModel> performanceModel) {
		listEmpiricalModel.put(dimension, performanceModel);
	}
	
	public static MutableObjectDoubleMap<ListCollectionType> predictPerformance(List<ListMetrics> collectionsState,
			PerformanceDimension dimension) {

		MutableObjectDoubleMap<ListCollectionType> performanceResult = new ObjectDoubleHashMap<>(listEmpiricalModel.size());

		List<ListPerformanceModel> models = listEmpiricalModel.get(dimension);
		
		// For each monitored collection
		for (ListMetrics state : collectionsState) {

			// For each model
			for (ListPerformanceModel model : models) {

				// Accumulate the performance of each implementation
				performanceResult.addToValue(model.getType(),
						model.calculatePerformance(state));
			}
		}

		return performanceResult;

	}

}