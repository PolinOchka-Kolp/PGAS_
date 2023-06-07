import ScienseSphere.*
import common.scienceSphere
import commonProps.CCommon
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

val CScienceCommon = FC<Props> { props ->
    div {
        CCommon {
            title = "Научно-исследовательская деятельность"
            sphere = scienceSphere
            listItem = listOf(
                CItem211,
                CItem212,
                CItem213,
                Item221,
                Item222
            )
            setValue = { num, newValue ->
                scienceSphere[num] = newValue
            }
        }
    }
}

