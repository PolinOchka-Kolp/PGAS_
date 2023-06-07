package StudySphere

//import react.dom.html.InputType
import common.studySphere
import commonProps.CCommonItem
import react.FC
import react.Props


val CItem11 = FC<Item>{ props ->
    CCommonItem {
        title = "1.1 Получение студентом в течение не менее двух следующих друг за другом сессий на \"отлично\""
        inputText = listOf("Кол-во сессий на \"отлично\"")
        selectList = emptyMap()
        checkBoxList = emptyList()
        sphere = studySphere[1]!!
        setValue = {
            props.setValue(1,it)
        }
    }
}


external interface Item : Props {
    var setValue: (Int,MutableMap<Int, MutableMap<String, String>>) -> Unit
}

val CItem12 = FC<Item> { props ->
    CCommonItem {
        title = "1.2 Получение студентом в течение года награды за результаты проектной деят-ти"
        sphere = studySphere[2]!!
        inputText = listOf("Достижение")
        inputDate = "Дата"
        selectList = mapOf(
            "Место (при наличии)" to arrayOf(
                "1 место",
                "2 место",
                "3 место"
            ), "Уровень мероприятия" to arrayOf(
                "Местный (кафедральный)",
                "Местный (факультетский)",
                "Местный (вузовский)",
                "Региональный (городской)",
                "Региональный (региональный)",
                "Региональный (межрегиональный)",
                "Региональный (окружной)",
                "Ведомственный",
                "Всероссийский",
                "Международный"
            )
        )
        checkBoxList = emptyList()
        setValue = {
            props.setValue(2,it)
        }
    }
}

val CItem13 = FC<Item> { props ->
    CCommonItem {
        title = "1.3 Признание студента победителем или призером олимпиады и тд, любого уровня"
        sphere = studySphere[3]!!
        inputDate = "Дата"
        inputText = listOf("Достижение")
        selectList = mapOf(
            "Вид мероприятия" to arrayOf("Предметный", "Профильный"),
            "Уровень мероприятия" to arrayOf(
                "Региональный",
                "Ведомственный",
                "Всероссийский",
                "Международный"
            ),
            "Место (при наличии)" to arrayOf(
                "1 место",
                "2 место",
                "3 место",
                "Золотой медалист",
                "Серебрянный медалист",
                "Бронзовый медалист",
                "Победитель",
                "Призер",
                "Финалист",
                "Полуфиналист"
            )
        )
        checkBoxList = emptyList()
        setValue = {
            props.setValue(3,it)
        }
    }
}


