package org.example;


import org.jetbrains.annotations.Nullable;

/**
 * @author 96361
 */
public class InputCommand {
    String commandPrefix;
    InputCommand command;

    @Nullable String targetName;
    @Nullable String targetId;
    @Nullable String targetStatus;


    public InputCommand(String commandPrefix, InputCommand command, @Nullable String targetName, @Nullable String targetId, @Nullable String targetStatus) {
        this.commandPrefix = commandPrefix;
        this.command = command;
        this.targetName = targetName;
        this.targetId = targetId;
        this.targetStatus = targetStatus;
    }

    /**
     * prefix list
     *
     * @param commandPrefix
     * @param command
     */
    public InputCommand(String commandPrefix, InputCommand command) {
        this.commandPrefix = commandPrefix;
        this.command = command;
    }

    /**
     * update
     *
     * @param commandPrefix
     * @param command
     * @param targetName
     * @param targetId
     */
    public InputCommand(String commandPrefix, InputCommand command, @Nullable String targetName, @Nullable String targetId) {
        this.commandPrefix = commandPrefix;
        this.command = command;
        this.targetName = targetName;
        this.targetId = targetId;
    }

    /**
     * add
     *
     * @param commandPrefix
     * @param command
     * @param targetName
     */
    public InputCommand(String commandPrefix, InputCommand command, @Nullable String targetName) {
        this.commandPrefix = commandPrefix;
        this.command = command;
        this.targetName = targetName;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setCommandPrefix(String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }

    public InputCommand getCommand() {
        return command;
    }

    public void setCommand(InputCommand command) {
        this.command = command;
    }

    public @Nullable String getTargetName() {
        return targetName;
    }

    public void setTargetName(@Nullable String targetName) {
        this.targetName = targetName;
    }

    public @Nullable String getTargetId() {
        return targetId;
    }

    public void setTargetId(@Nullable String targetId) {
        this.targetId = targetId;
    }

    public @Nullable String getTargetStatus() {
        return targetStatus;
    }

    public void setTargetStatus(@Nullable String targetStatus) {
        this.targetStatus = targetStatus;
    }
}
