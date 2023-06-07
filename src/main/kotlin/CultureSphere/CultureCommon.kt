import CultureSphere.CItem41
import CultureSphere.CItem42
import CultureSphere.CItem43
import common.cultureSphere
import commonProps.CCommon
import react.FC
import react.Props
import react.dom.html.ReactHTML.div


val CCultureCommon = FC<Props> {
    div {
        CCommon {
            title = "Культурно-творческая деятельность"
            listItem = listOf(CItem41, CItem42, CItem43)
            sphere = cultureSphere
            setValue = { num, newValue ->
                cultureSphere[num] = newValue
            }
        }
    }
}

