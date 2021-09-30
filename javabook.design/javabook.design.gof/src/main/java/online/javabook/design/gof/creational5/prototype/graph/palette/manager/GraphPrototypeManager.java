package online.javabook.design.gof.creational5.prototype.graph.palette.manager;

import online.javabook.design.gof.creational5.prototype.graph.palette.product.IGraphPrototype;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GraphPrototypeManager {
	
	private Map<String, IGraphPrototype> graphPrototypeHashMap = new HashMap<>();

	public void register(Class graphPrototypeClass, IGraphPrototype graphPrototype) {
		graphPrototypeHashMap.put(graphPrototypeClass.getName(), graphPrototype);
	}

	public IGraphPrototype shallowClone(Class graphPrototypeClass) throws CloneNotSupportedException {
		IGraphPrototype graphPrototype = graphPrototypeHashMap.get(graphPrototypeClass.getName());
		return graphPrototype.shallowClone();
	}

	public IGraphPrototype deepClone(Class graphPrototypeClass) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		IGraphPrototype graphPrototype = graphPrototypeHashMap.get(graphPrototypeClass.getName());
		return graphPrototype.deepClone();
	}
}
