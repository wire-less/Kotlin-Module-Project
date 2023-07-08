package ArchivesList

import MenuList.Menu
import NotesList.Notes
import NotesList.NotesMenu
import java.util.Scanner

class ArchivesMenu: Menu() {
    val archiveMenu: MutableList<Archive> = mutableListOf(
        Archive("Создать архив", mutableListOf()),
        Archive("Выход", mutableListOf())
    )
    override val menuName: String
        get() = "\nСписок архивов:"
    val notesMenu = NotesMenu()

    fun addArchive() {
        println("Введите название архива")
        val emptyArcMessage = "Наименование архива не может быть пустым. Введите название архива:"
        while (true) {
            try {
                val userInput = Scanner(System.`in`).nextLine()
                if (userInput.isBlank()) {
                    println(emptyArcMessage)
                    continue
                }
                archiveMenu.add(archiveMenu.size - 1, Archive(userInput, mutableListOf()))
                return
            } catch (e: java.util.InputMismatchException) {
                println(emptyArcMessage)
            }
        }
        }

    fun popupArchiveMenu(): MutableList<Notes> {
        while (true) {
            showMenu(archiveMenu)
            val amountElements = archiveMenu.size - 1
            val menuItem = handleExceptions(amountElements)
            when (menuItem) {
                0 -> addArchive()
                archiveMenu.size - 1 -> System.exit(0)
                else -> notesMenu.popupNotesMenu(archiveMenu.get(menuItem).notesList)
            }

        }
    }
}
