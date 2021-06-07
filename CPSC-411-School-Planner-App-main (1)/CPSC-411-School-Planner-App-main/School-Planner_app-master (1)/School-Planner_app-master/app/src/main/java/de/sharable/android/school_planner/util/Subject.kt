package de.sharable.android.school_planner.util

import android.content.res.Resources
import de.sharable.android.school_planner.R

enum class Subject(val abbreviation: String, val color: Int, val actualName: Int) {

    BIOLOGY("Bio", R.color.subject_biology, R.string.subject_biology),
    MATHEMATICS("M", R.color.subject_mathematics, R.string.subject_mathematics),
    ENGLISH("E", R.color.subject_english, R.string.subject_english),
    PHYSICS("Ph", R.color.subject_physics, R.string.subject_physics),
    COMPUTERSCIENCE("CS", R.color.subject_computerscience, R.string.subject_computerscience),
    ETHNICS("Eth", R.color.subject_ethnics, R.string.subject_ethnics),
    CHEMISTRY("Ch", R.color.subject_chemistry, R.string.subject_chemistry);

    companion object {
        fun fromAbbreviation(abbreviation: String): Subject? {
            for (subject: Subject in values()) {
                if(subject.abbreviation == abbreviation) {
                    return subject
                }
            }

            return null
        }

        fun fromName(name: String, resources: Resources): Subject? {
            for(subject: Subject in values()) {
                if(resources.getString(subject.actualName) == name) {
                    return subject
                }
            }

            return null
        }

        fun toStringArray(resources: Resources): Array<String> {
            return Array(values().size) { i -> resources.getString(values()[i].actualName) }
        }
    }

}