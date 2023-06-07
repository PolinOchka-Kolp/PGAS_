import SportSphere.CItem511
import SportSphere.CItem512
import SportSphere.CItem52
import SportSphere.CItem53
import common.sportSphere
import commonProps.CCommon
import react.FC
import react.Props

val CSportCommon = FC<Props> {
    CCommon {
        title = "Спортивная деятельность"
        sphere = sportSphere
        listItem = listOf(
            CItem511,
            CItem512,
            CItem52,
            CItem53
        )
        setValue = {num, newValue ->
            sportSphere[num] = newValue
        }
    }
}

