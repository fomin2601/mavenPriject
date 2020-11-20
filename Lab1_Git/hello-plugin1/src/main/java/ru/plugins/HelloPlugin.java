package ru.plugins;

import ru.plugin.Plugin;
import ru.plugin.PluginContext;

public class HelloPlugin implements Plugin
{
	private PluginContext pc;
	
	@Override
	public void invoke() {
		// TODO Auto-generated method stub
		System.out.println("Hello world. I am a plugin 1");
		pc.getButton().setText("Other text 1");
	}

	@Override
	public void init(PluginContext context) {
		// TODO Auto-generated method stub
		this.pc = context;
	}

}
