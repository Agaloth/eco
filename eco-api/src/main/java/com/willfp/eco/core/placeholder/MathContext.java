package com.willfp.eco.core.placeholder;

import com.willfp.eco.core.integrations.placeholder.PlaceholderManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

/**
 * Represents a context to do math in.
 *
 * @param injectableContext The PlaceholderInjectable context.
 * @param player            The player.
 * @param additionalPlayers The additional players.
 */
public record MathContext(
        @NotNull PlaceholderInjectable injectableContext,
        @Nullable Player player,
        @NotNull Collection<AdditionalPlayer> additionalPlayers
) {
    /**
     * Empty math context.
     */
    public static final MathContext EMPTY = new MathContext(
            PlaceholderManager.EMPTY_INJECTABLE,
            null,
            Collections.emptyList()
    );
}
