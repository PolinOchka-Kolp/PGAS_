import StudySphere.CItem11
import StudySphere.CItem12
import StudySphere.CItem13
import common.studySphere
import commonProps.CCommon
import react.FC
import react.Props

val CStudyCommon = FC<Props> {
    CCommon {
        title = "Учебная деятельность"
        sphere = studySphere
        listItem = listOf(
            CItem11,
            CItem12,
            CItem13
        )
        setValue = { num, newValue ->
            studySphere[num] = newValue
        }

    }
}

