package io.github.vnicius.ffmpegdslandroid.ffmpegcommand.filter

import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.command.CommandArgumentParser
import io.github.vnicius.ffmpegdslandroid.ffmpegcommand.streamspecifier.StreamSpecifier

class FilterGroup(
    val inputStreamSpecifier: StreamSpecifier? = null,
    val outputStreamSpecifier: StreamSpecifier? = null
) :
    CommandArgumentParser, TaggedFilter {
    private val filters: MutableList<Filter> = mutableListOf()
    private val filterTagGenerator = FilterTagGenerator()

    override val inputTag: String =
        filterTagGenerator.generateTagFromStreamSpecifier(inputStreamSpecifier)
    override val outputTag: String =
        filterTagGenerator.generateTagFromStreamSpecifier(outputStreamSpecifier)

    fun addFilter(filter: Filter) {
        filters.add(filter)
    }

    override fun parseToString(): String {
        val filtersString = filters.joinToString(",") { it.parseToString() }

        return "$inputTag$filtersString$outputTag;"
    }

    override fun toString(): String =
        parseToString()
}