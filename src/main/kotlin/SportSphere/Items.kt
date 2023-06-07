package SportSphere

import StudySphere.Item
import common.sportSphere
import commonProps.CCommonItem
import react.FC
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div

val CItem512 = FC<Item>{ props ->
    CCommonItem {
        title = "5.1.2 Получение студентом спортивного разряда и звания"
        sphere = sportSphere[2]!!
        inputDate = "Дата получения разряда/звания"
        inputText = emptyList()
        selectList = mapOf(
            "Спортивный разряд/звание" to arrayOf(
                "Заслуженный мастер спорта России (ЗМС)",
                "Мастер спорта России международного класса (МСМК)",
                "Мастер спорта России (МС)",
                "1-й спортивный разряд",
                "2-й спортивный разряд",
                "3-й спортивный разряд"
            )
        )
        checkBoxList = emptyList()
        setValue = {
            props.setValue(2,it)
        }
    }
}

val CItem52 = FC<Item>{ props ->
    CCommonItem {
        title =
            "5.2 Систематическое участие студента в спортивных мероприятиях различного характера и иных общественно значимых спортивных мероприятиях"
        sphere = sportSphere[3]!!
        inputDate = "Дата"
        selectList = mapOf(
            "Уровень мероприятия" to arrayOf(
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
        inputText = emptyList()
        checkBoxList = emptyList()
        setValue = {
            props.setValue(3,it)
        }
    }
}

val CItem53 = FC<Item>{ props ->
    CCommonItem {
        title = "5.3 Выполнение нормативов и требований золотого знака отличия ГТО соответствующей возрастной группы"
        inputDate = "Дата получения знака ГТО"
        sphere = sportSphere[4]!!
        inputText = emptyList()
        checkBoxList = listOf("Наличие золотого знака ГТО")
        selectList = emptyMap()
        setValue = {
            props.setValue(4,it)
        }
    }
}
val CItem511 = FC<Item>{ props ->
    div {
        ReactHTML.h5 {
            +"5.1 Получение студентом в течение года награды за результаты спортивной деятельности в рамках мероприятий различного уровня, проводимых университетом или спортивными организациями"
        }
        CCommonItem {
            title = "5.1.1 Получение студентом награды за результаты спортивной деятельности"
            sphere = sportSphere[1]!!
            inputText = listOf("Название мероприятия")
            inputDate = "Дата"
            selectList = mapOf(
                "Уровень мероприятия" to arrayOf(
                    "Региональный",
                    "Ведомственный",
                    "Всероссийский",
                    "Международный"
                ), "Место" to arrayOf(
                    "1 место",
                    "2 место",
                    "3 место"
                )
            )
            checkBoxList = emptyList()
            setValue = {
                props.setValue(1,it)
            }
        }
    }

}

