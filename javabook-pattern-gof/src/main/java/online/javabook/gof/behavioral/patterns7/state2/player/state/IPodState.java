package online.javabook.gof.behavioral.patterns7.state2.player.state;

import online.javabook.gof.behavioral.patterns7.state2.player.context.IPod;

public interface IPodState {
	
	 void change(IPod pod);
}
