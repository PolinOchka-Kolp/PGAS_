package common

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.js.Date

fun date(): String {
    val currentDate = Date()
    val year = currentDate.getFullYear()
    var month = (currentDate.getMonth() + 1).toString()
    if (month.length < 2)
        month = "0$month"
    var day = currentDate.getDate().toString()
    if (day.length < 2)
        day = "0$day"
    return "$year-$month-$day"
}

fun minDate(): String {
    val currentDate = Date()
    val year = currentDate.getFullYear() - 1
    var month = (currentDate.getMonth() + 1).toString()
    if (month.length < 2)
        month = "0$month"
    var day = currentDate.getDate().toString()
    if (day.length < 2)
        day = "0$day"
    return "$year-$month-$day"
}


val studySphere: MutableMap<Int, MutableMap<Int, MutableMap<String, String>>> = mutableMapOf(
    1 to mutableMapOf(1 to mutableMapOf("Кол-во сессий на \"отлично\"" to "")),
    2 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Достижение" to "",
            "Место (при наличии)" to "",
            "Уровень мероприятия" to ""
        )
    ),
    3 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Достижение" to "",
            "Место (при наличии)" to "",
            "Уровень мероприятия" to "",
            "Вид мероприятия" to "",
        )
    ),
)

val scienceSphere: MutableMap<Int, MutableMap<Int, MutableMap<String, String>>> = mutableMapOf(
    1 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Достижение" to "",
            "Место" to "",
            "Уровень мероприятия" to ""
        )
    ),
    2 to mutableMapOf(1 to mutableMapOf("Дата" to date(), "Достижение" to "", "Вид документа" to "")),
    3 to mutableMapOf(1 to mutableMapOf("Дата" to date(), "Название гранта" to "", "Финансируется:" to "")),
    4 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название статьи" to "",
            "Количество авторов статьи" to "",
            "Издание" to "",
            "Наличие рецензии" to ""
        )
    ),
    5 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название статьи" to "",
            "Уровень конференции" to "",
            "Количество авторов статьи" to "",
            "Издание" to "",
            "Наличие рецензии" to ""
        )
    )
)

val societySphere: MutableMap<Int, MutableMap<Int, MutableMap<String, String>>> = mutableMapOf(
    1 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название мероприятия" to "",
            "Уровень мероприятия" to "",
            "Организовано в ОмГУПС" to "",
            "Степень участия" to "",
            "Мероприятие входит в список ППОС ОмГУПС" to ""
        )
    ),
    2 to mutableMapOf(1 to mutableMapOf("Дата протокола" to date(), "Орган" to "", "Роль" to "")),
    3 to mutableMapOf(1 to mutableMapOf("Дата" to date(), "Название гранта" to "", "Вид гранта" to "")),
    4 to mutableMapOf(
        1 to mutableMapOf(
            "Количество месяцев" to "",
            "Срок деятельности" to "",
            "Перечень задач" to ""
        )
    ),
    5 to mutableMapOf(
        1 to mutableMapOf(
            "Дата публикации" to date(),
            "Название публикации" to "",
            "Наличие публикации в СМИ:" to "",
            "Участие в разработке/администрировании сайта:" to ""
        )
    ),
    6 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название мероприятия" to "",
            "Уровень мероприятия" to ""
        )
    )
)

val cultureSphere: MutableMap<Int, MutableMap<Int, MutableMap<String, String>>> = mutableMapOf(
    1 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название мероприятия" to "",
            "Уровень мероприятия" to "",
            "Место" to ""
        )
    ),
    2 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название мероприятия" to "",
            "Уровень мероприятия" to ""
        )
    ),
    3 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название мероприятия" to ""
        )
    ),
)

val sportSphere: MutableMap<Int, MutableMap<Int, MutableMap<String, String>>> = mutableMapOf(
    1 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Название мероприятия" to "",
            "Уровень мероприятия" to "",
            "Место" to ""
        )
    ),
    2 to mutableMapOf(
        1 to mutableMapOf(
            "Дата получения разряда/звания" to date(),
            "Спортивный разряд/звание" to ""
        )
    ),
    3 to mutableMapOf(
        1 to mutableMapOf(
            "Дата" to date(),
            "Уровень мероприятия" to ""
        )
    ),
    4 to mutableMapOf(
        1 to mutableMapOf(
            "Дата получения знака ГТО" to date(),
            "Наличие золотого знака ГТО" to ""
        )
    ),
)

fun studySphereNotEmpty(): Map<String, Map<Int, Map<String, String>>> {
    val criterion = arrayOf(
        "Получение студентом в течение не менее двух следующих друг за другом сессий на \"отлично\"",
        "Получение студентом в течение года награды за результаты проектной деят-ти",
        "Признание студента победителем или призером олимпиады и тд, любого уровня"
    )
    var count = -1
    val a = studySphere.mapNotNull {
        count++
        criterion[count] to it.value.mapNotNull {
            if (it.value.values.contains(""))
                null
            else
                it.key to it.value.toMap()
        }.toMap()
    }.toMap()
    return a
}

fun scienceSphereNotEmpty(): Map<String, Map<Int, Map<String, String>>> {
    val criterion = arrayOf(
        "Награды за результаты научно-исследовательской работы",
        "Исключительное право студента на достигнутый им научный результат интеллектуальной деятельности",
        "Грант на выполнение научно-исследовательской работы",
        "Статьи в научном журнале",
        "Публикации в сборниках трудов и материалов конференции"
    )
    var count = -1
    val a = scienceSphere.mapNotNull {
        count++
        criterion[count] to it.value.mapNotNull {
            if (it.value.values.contains(""))
                null
            else
                it.key to it.value.toMap()
        }.toMap()
    }.toMap()
    return a
}

fun societySphereNotEmpty(): Map<String, Map<Int, Map<String, String>>> {
    val criterion = arrayOf(
        "Систематическое участие студента в проведении мероприятий",
        "Систематическое участие студента в деятельности правозащитного характера",
        "Получение гранта на выполнение социальных проектов",
        "Деятельность по техническому сопровождению общественного объединения",
        "Деятельность по информационному обеспечению общественно-значимых мероприятий",
        "Участие студента в общественно-значимой деятельности, направленной на формирование у детей и молодёжи общероссийской гражданской идентичности"
    )
    var count = -1
    val a = societySphere.mapNotNull {
        count++
        criterion[count] to it.value.mapNotNull {
            if (it.value.values.contains(""))
                null
            else
                it.key to it.value.toMap()
        }.toMap()
    }.toMap()
    return a
}

fun cultureSphereNotEmpty(): Map<String, Map<Int, Map<String, String>>> {
    val criterion = arrayOf(
        "Получение студентом в течение года, награды за результаты культурно-творческой деятельности",
        "Публичное представление студентом в течение года, созданного им произведения литературы или исскуства",
        "Систематическое участие студента в проведении публичной культкрно-творческой деятельности"
    )
    var count = -1
    val a = cultureSphere.mapNotNull {
        count++
        criterion[count] to it.value.mapNotNull {
            if (it.value.values.contains(""))
                null
            else
                it.key to it.value.toMap()
        }.toMap()
    }.toMap()
    return a
}

fun sportSphereNotEmpty(): Map<String, Map<Int, Map<String, String>>> {
    val criterion = arrayOf(
        "Получение студентом награды за результаты спортивной деятельности",
        "Получение студентом спортивного разряда и звания",
        "Систематическое участие студента в спортивных мероприятиях различного характера и иных общественно значимых спортивных мероприятиях",
        "Выполнение нормативов и требований золотого знака отличия ГТО соответствующей возрастной группы"
    )
    var count = -1
    val a = sportSphere.mapNotNull {
        count++
        criterion[count] to it.value.mapNotNull {
            if (it.value.values.contains(""))
                null
            else
                it.key to it.value.toMap()
        }.toMap()
    }.toMap()
    return a
}

var person = mutableMapOf("Фио" to "", "Группа" to "", "Телефон" to "")

fun jsonCreate(): String {
    val person = person.map {
        "${it.key}:${it.value}"
    }.joinToString(",", "\"", "\"")
    val a = Json.encodeToString(studySphereNotEmpty())
    val b = Json.encodeToString(societySphereNotEmpty())
    val c = Json.encodeToString(scienceSphereNotEmpty())
    val d = Json.encodeToString(cultureSphereNotEmpty())
    val e = Json.encodeToString(sportSphereNotEmpty())
    return "{$person:{\"Учебная деятельность\":${a}," +
            "\"Научно-исследовательская деятельность\":${b}," +
            "\"Общественная деятельность\":${c}," +
            "\"Культурно-творческая деятельность\":${d}," +
            "\"Спортивная деятельность\":${e}}}"
}


