package org.gof.creational.patterns5.prototype.app.tools.manager;

import org.gof.creational.patterns5.prototype.app.tools.product.IFigurePrototype;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ToolPanel {
	
	private Map<String, IFigurePrototype> figures = new HashMap<>();

	public void register(Class figureClass, IFigurePrototype figurePrototype) {
		figures.put(figureClass.getName(), figurePrototype);
	}

	public IFigurePrototype shallowClone(Class figureClass) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		IFigurePrototype figure = figures.get(figureClass.getName());
		return figure.shallowClone();
	}

	public IFigurePrototype deepClone(Class figureClass) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		IFigurePrototype figure = figures.get(figureClass.getName());
		return figure.deepClone();
	}
}
