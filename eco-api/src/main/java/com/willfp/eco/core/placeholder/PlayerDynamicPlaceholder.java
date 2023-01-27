package com.willfp.eco.core.placeholder;

import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.integrations.placeholder.PlaceholderManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

/**
 * A placeholder that does not require a player and supports dynamic styles.
 */
public final class PlayerDynamicPlaceholder implements Placeholder {
    /**
     * The placeholder pattern.
     */
    private final Pattern pattern;

    /**
     * The function to retrieve the output of the placeholder.
     */
    private final BiFunction<String, Player, String> function;

    /**
     * The plugin for the placeholder.
     */
    private final EcoPlugin plugin;

    /**
     * Create a new dynamic placeholder.
     *
     * @param plugin   The plugin.
     * @param pattern  The pattern.
     * @param function The function to retrieve the value.
     */
    public PlayerDynamicPlaceholder(@NotNull final EcoPlugin plugin,
                                    @NotNull final Pattern pattern,
                                    @NotNull final BiFunction<String, Player, String> function) {
        this.plugin = plugin;
        this.pattern = pattern;
        this.function = function;
    }

    /**
     * Get the value of the placeholder.
     *
     * @param args   The args.
     * @param player The player.
     * @return The value.
     */
    @NotNull
    public String getValue(@NotNull final String args,
                           @NotNull final Player player) {
        return function.apply(args, player);
    }

    /**
     * Register the placeholder.
     *
     * @return The placeholder.
     */
    public PlayerDynamicPlaceholder register() {
        PlaceholderManager.registerPlaceholder(this);
        return this;
    }

    @Override
    public @NotNull EcoPlugin getPlugin() {
        return this.plugin;
    }

    @Override
    @Deprecated
    public @NotNull String getIdentifier() {
        return "dynamic";
    }

    @NotNull
    @Override
    public Pattern getPattern() {
        return this.pattern;
    }

    @Override
    public boolean equals(@Nullable final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof PlayerDynamicPlaceholder that)) {
            return false;
        }

        return Objects.equals(this.getPattern(), that.getPattern())
                && Objects.equals(this.getPlugin(), that.getPlugin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdentifier(), this.getPlugin());
    }
}
