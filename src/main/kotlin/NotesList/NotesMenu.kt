package NotesList

import MenuList.Menu
import java.util.Scanner


class   NotesMenu: Menu() {
    override val menuName: String
        get() = "\nСписок заметок:"

    fun addNote(notesMenu: MutableList<Notes>) {

        var noteName: String
        while (true)
        {
        println("Введите название заметки")
        noteName = Scanner(System.`in`).nextLine()
            if (noteName.isNotBlank()) break
            else println("Наименование заметки не может быть пустым")
        }

        while (true)
        {
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
            if (noteText.isNotBlank()) {
                notesMenu.add(notesMenu.size - 1, Notes(noteName, noteText))
                println("Заметка создана")
                return
            }
            else println("Текст заметки не может быть пустым")
    }
    }

    fun popupNotesMenu(notesMenu: MutableList<Notes>) {
        if (notesMenu.size == 0) {
            notesMenu.add(Notes("Создать заметку", ""))
            notesMenu.add(Notes("Выход", ""))
        }
        while (true) {
            showMenu(notesMenu)
            val amountElements = notesMenu.size - 1
            val menuItem = handleExceptions(amountElements)
            when (menuItem) {
                0 -> addNote(notesMenu)
                notesMenu.size - 1 -> return
                else -> println(notesMenu.get(menuItem).textNote)
            }
        }
    }
}
