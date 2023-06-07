import SocietySphere.*
import common.societySphere
import common.sportSphere
import commonProps.CCommon
import react.FC
import react.Props


val CSocietyCommon = FC<Props> {
    CCommon {
        title = "Общественная деятельность"
        sphere = societySphere
        listItem = listOf(
            CItem311,
            CItem312,
            CItem313,
            CItem314,
            CItem32,
            CItem33,
        )
        setValue = {num, newValue ->
            sportSphere[num] = newValue
        }
    }
}

