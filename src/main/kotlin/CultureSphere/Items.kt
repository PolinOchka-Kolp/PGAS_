package CultureSphere

import StudySphere.Item
import common.cultureSphere
import commonProps.CCommonItem
import react.FC
import react.Props
//import react.dom.html.InputType


val CItem43 =  FC<Item>{ props ->
    CCommonItem {
        title = "4.3 Систематическое участие студента в проведении публичной культкрно-творческой деятельности"
        inputDate = "Дата"
        inputText = listOf("Название мероприятия")
        sphere = cultureSphere[3]!!
        selectList = emptyMap()
        checkBoxList = emptyList()
        setValue = {
            props.setValue(3,it)
        }
    }
}

val CItem41 =  FC<Item>{ props ->
    CCommonItem {
        title = "4.1 Получение студентом в течение года, награды за результаты культурно-творческой деятельности"
        inputDate = "Дата"
        sphere = cultureSphere[1]!!
        inputText = listOf("Название мероприятия")
        selectList = mapOf(
            "Уровень мероприятия"
                    to arrayOf(
                "Региональный",
                "Ведомственный",
                "Всероссийский",
                "Международный"
            ),
            "Место"
                    to arrayOf(
                "Гран-при",
                "1 место",
                "2 место",
                "3 место",
                "Лауреат/дипломат/призер (спец. приз)"
            )
        )
        checkBoxList = emptyList()
        setValue = {
            props.setValue(1,it)
        }
    }
}

val CItem42 =  FC<Item>{ props ->
    CCommonItem {
        title = "4.2 Публичное представление студентом в течение года, созданного им произведения литературы или исскуства"
        inputDate = "Дата"
        sphere = cultureSphere[2]!!
        inputText = listOf("Название мероприятия")
        selectList = mapOf(
            "Уровень мероприятия"
                    to arrayOf(
                    "Местный (в т.ч. вузовский)",
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
