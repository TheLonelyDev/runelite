package net.runelite.client.plugins.requestsnotifcations;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "requestsnotifications",
	name = "RequestsNotifications",
	description = "Configuration for the trade and duel requests"
)
public interface RequestsNotificationsConfig extends Config
{
	@ConfigItem(
		keyName = "tradeRequest",
		name = "Enable trade requests",
		description = "Enable trade requests"
	)
	default boolean tradeRequest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "duelRequest",
		name = "Enable duel requests",
		description = "Enable duel requests"
	)
	default boolean duelRequest()
	{
		return true;
	}
}
