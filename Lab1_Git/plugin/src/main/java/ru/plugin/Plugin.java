package ru.plugin;

public interface Plugin
{
	public void invoke();
	public void init(PluginContext context);
}
