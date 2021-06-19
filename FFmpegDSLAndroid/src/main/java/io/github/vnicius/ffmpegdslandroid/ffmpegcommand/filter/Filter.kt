package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.KeyCommandArgument
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.ValueCommandArgument

abstract class Filter: KeyCommandArgument, ValueCommandArgument, CommandArgumentParser {
    override fun parseToString(): String =
        "${key.trim()}=${value.trim()}"

    override fun toString(): String =
        parseToString()
}