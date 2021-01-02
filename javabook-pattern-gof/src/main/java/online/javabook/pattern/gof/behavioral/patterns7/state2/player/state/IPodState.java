package online.javabook.pattern.gof.behavioral.patterns7.state2.player.state;

import online.javabook.pattern.gof.behavioral.patterns7.state2.player.context.IPod;

public interface IPodState {
	
	 void change(IPod pod);
}
