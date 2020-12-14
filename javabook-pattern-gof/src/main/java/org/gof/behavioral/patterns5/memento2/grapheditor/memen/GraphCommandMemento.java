package org.gof.behavioral.patterns5.memento2.grapheditor.memen;

import org.gof.behavioral.patterns5.memento2.grapheditor.command.IGraphCommand;

public class GraphCommandMemento {

    private IGraphCommand graphCommand;

    public GraphCommandMemento(IGraphCommand graphCommand){
        this.graphCommand = graphCommand;
    }

    public IGraphCommand getState(){
        return graphCommand;
    }
}
