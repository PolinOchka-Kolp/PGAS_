package SocietySphere

import StudySphere.Item
import common.societySphere
import commonProps.CCommonItem
import react.FC
import react.dom.html.ReactHTML


val CItem33 = FC<Item>{ props ->
    CCommonItem {
        title =
            "3.3 Участие студента в общественно-значимой деятельности, направленной на формирование у детей и молодёжи общероссийской гражданской идентичности"
        inputDate = "Дата"
        inputText = listOf("Название мероприятия")
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
        checkBoxList = emptyList()
        sphere = societySphere[6]!!
        setValue = {
            props.setValue(6,it)
        }
    }

}
val CItem32 = FC<Item>{ props ->
    CCommonItem {
        title = "3.2 Деятельность по информационному обеспечению общественно-значимых мероприятий"
        sphere = societySphere[5]!!
        inputDate = "Дата публикации"
        inputText = listOf("Название публикации")
        selectList = mapOf(
            "Наличие публикации в СМИ:" to
                    arrayOf(
                        "Университета",
                        "Региональных",
                        "Ведомственных",
                        "Федеральных"
                    ),
            "Участие в разработке/администрировании сайта:" to arrayOf(
                "Университета",
                "Факультета"
            )
        )
        setValue = {
            props.setValue(5,it)
        }
        checkBoxList = emptyList()
    }
}

val CItem314 = FC<Item>{ props ->
    CCommonItem {
        title = "3.1.4 Деятельность по техническому сопровождению общественного объединения"
        sphere = societySphere[4]!!
        inputText = listOf("Количество месяцев", "Срок деятельности", "Перечень задач")
        selectList = emptyMap()
        checkBoxList = emptyList()
        setValue = {
            props.setValue(4,it)
        }
    }
}

val CItem313 = FC<Item>{ props ->
    CCommonItem {
        title = "3.1.3 Получение гранта на выполнение социальных проектов"
        inputDate = "Дата"
        sphere = societySphere[3]!!
        inputText = listOf(
            "Название гранта"
        )

        selectList = mapOf(
            "Вид гранта" to arrayOf(
                "Президентские гранты",
                "Грант Росмолодежи",
                "Прочие гранты"
            )
        )
        checkBoxList = emptyList()
        setValue = {
            props.setValue(3,it)
        }
    }
}
val CItem312 = FC<Item>{ props ->
    CCommonItem {
        title = "3.1.2 Систематическое участие студента в деятельности правозащитного характера"
        sphere = societySphere[2]!!
        inputDate = "Дата протокола"
        setValue = {
            props.setValue(2,it)
        }
        selectList = mapOf(
            "Орган" to arrayOf(
                "Староста",
                "Профорг",
                "ФПО",
                "УВК",
                "Студенческие объединения",
                "Профком студентов",
                "Совет обучающихся",
                "Ученый совет института",
                "Ученый совет университета"
            ),
            "Роль"
                    to arrayOf(
                "Член",
                "Заместитель председателя",
                "Председатель",
                "Руководитель"
            )
        )
        inputText = emptyList()
        checkBoxList = emptyList()
    }
}

val CItem311 = FC<Item>{ props ->
    ReactHTML.h5 {
        +"3.1 Систематическое участие студента в течение года в проведении общественно-значимой деятельности"
    }
    CCommonItem {
        title = "3.1.1 Систематическое участие студента в проведении мероприятий"
        inputDate = "Дата"
        inputText = listOf(
            "Название мероприятия",
        )
        selectList = mapOf(
            "Уровень мероприятия"
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
            ), "Степень участия"
                    to arrayOf(
                "Руководитель",
                "Организатор",
                "Модератор",
                "Волонтер",
                "Исполнитель"
            )
        )
        checkBoxList = listOf("Организовано в ОмГУПС", "Мероприятие входит в список ППОС ОмГУПС")
        sphere = societySphere[1]!!
        setValue = {
            props.setValue(1,it)
        }
    }
}

