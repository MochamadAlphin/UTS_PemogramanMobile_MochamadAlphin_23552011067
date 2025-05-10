package com.example.uts_project_medicipaw
data class ChatMessage(
    val profileImage: Int,
    val userName: String,      // Pastikan ada properti ini
    val lastMessage: String,    // Pastikan ada properti ini
    val time: String,
    val category: String        // Jika ada kategori
)