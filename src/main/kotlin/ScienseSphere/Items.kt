package ScienseSphere

import StudySphere.Item
import common.scienceSphere
import commonProps.CCommonItem
import react.FC
import react.dom.html.ReactHTML


val CItem213 = FC<Item>{ props ->
    CCommonItem {
        title = "2.1.3 Грант на выполнение научно-исследовательской работы"
        sphere = scienceSphere[3]!!
        inputDate = "Дата"
        inputText = listOf("Название гранта")
        selectList = mapOf("Финансируется:"
                to arrayOf(
                "Российский научный фонд",
            "Совет по грантам Президента РФ",
            "Фонд содействия инновациям",
            "Иное"
        ))
        checkBoxList = emptyList()
        setValue = {
            props.setValue(3,it)
        }
    }
}

val CItem211 = FC<Item>{ props ->
    ReactHTML.h5 {
        +"2.1 Получение студентом:"
    }
    CCommonItem {
        title = "2.1.1 Награды за результаты научно-исследовательской работы"
        sphere = scienceSphere[1]!!
        inputDate = "Дата"
        inputText = listOf("Достижение")
        selectList = mapOf(
            "Место"
                    to arrayOf(
                "1 место",
                "2 место",
                "3 место",
                "Финалист",
                "Полуфиналист"
            ), "Уровень мероприятия"
                    to arrayOf(
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
            props.setValue(1,it)
        }
    }
}

val CItem212 = FC<Item>{ props ->
    CCommonItem {
        title = "2.1.2 Исключительное право студента на достигнутый им научный результат интеллектуальной деятельности"
        sphere = scienceSphere[2]!!
        inputDate = "Дата"
        selectList = mapOf(
            "Вид документа"
                    to arrayOf(
                "Патент РФ на изобретение",
                "Патент РФ на полезную модель",
                "Свидетельство о гос.регистрации программы для ЭВМ"
            ) )
        inputText = listOf("Достижение")
        checkBoxList = emptyList()
        setValue = {
            props.setValue(4,it)
        }
    }
}