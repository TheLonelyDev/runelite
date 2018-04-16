package net.runelite.client.plugins.requestsnotifcations;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Requests Notifications",
	enabledByDefault = false
)
@Slf4j
public class RequestNotificationsPlugin extends Plugin
{
	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private RequestsNotificationsConfig config;

	@Provides
	RequestsNotificationsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RequestsNotificationsConfig.class);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if ((config.tradeRequest() && event.getType() == ChatMessageType.TRADE) || (config.duelRequest() && event.getType() == ChatMessageType.DUEL))
		{
			notifier.notify(event.getMessage());
		}
	}
}
