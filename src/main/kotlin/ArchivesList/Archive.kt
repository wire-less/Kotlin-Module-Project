package ArchivesList

import MenuList.MenuItem
import NotesList.Notes

class Archive(
    val name: String,
    val notesList: MutableList<Notes>
): MenuItem {
    override val menuItem: String
        get() = name
}
