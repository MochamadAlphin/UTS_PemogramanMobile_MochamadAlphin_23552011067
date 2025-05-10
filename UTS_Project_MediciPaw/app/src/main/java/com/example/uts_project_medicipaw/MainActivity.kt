package com.example.uts_project_medicipaw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chatList: List<ChatMessage>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_chatting)

        recyclerView = findViewById(R.id.recyclerView_chats)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val chatList = listOf(
            ChatMessage(R.drawable.icon, "Dr. Dicki Firmansyah", "Jangan lupa berikan obatnya, ya! 😠", "5m ago", "Spesialis Kardiologi"),
            ChatMessage(R.drawable.icon, "Dr. Muhammad Akbar", "Jika ada gejala baru, konsultasikan lagi! ☺️", "3m ago", "Dokter Hewan Umum"),
            ChatMessage(R.drawable.icon, "Dr. Muhamad Abdul", "PROMO SHAMPO KUCING GRATIS! 🥳", "10m ago", "Dokter Hewan Umum"),
            ChatMessage(R.drawable.icon, "Dr. Muhhamad Fikri", "Bagaimana kesehatan kucingmu? Semoga baik! 😊", "1h ago", "Spesialis Kucing"),
            ChatMessage(R.drawable.icon, "Dr. Salsabila Syazwani", "Pastikan makanan dan minumannya cukup, ya! 🐱", "1h ago", "Spesialis Nutrisi"),
            ChatMessage(R.drawable.icon, "Dr. Lisa Ayu", "Cek kesehatan hewanmu, jangan sampai mereka mengancam! 😾", "2h ago", "Dokter Hewan Umum"),
            ChatMessage(R.drawable.icon, "Dr. Sheila Hamidah", "Jangan biarkan hewanmu sakit, bawa ke dokter jika perlu! 🏥", "5h ago", "Spesialis Bedah"),
            ChatMessage(R.drawable.icon, "Dr. Anisa Wulandari", "Pastikan hewanmu fit, agar tidak mengacaukan rencana! ☀️", "3h ago", "Dokter Hewan Umum"),
            ChatMessage(R.drawable.icon, "Dr. Arika Azhar", "Cek kesehatan hewanmu, agar tidak ada sesi ‘apa yang salah’? 😮", "10h ago", "Spesialis Penyakit Dalam"),
            ChatMessage(R.drawable.icon, "Dr. Rafti Rahayu", "Pastikan hewanmu bugar, biar tidak mengalihkan perhatian! 🤪", "2d ago", "Spesialis Gigi"),
            ChatMessage(R.drawable.icon, "Dr. Galih Andre", "Jangan lupa jaga kesehatan hewanmu! 😺", "2h ago", "Dokter Hewan Umum"),
            ChatMessage(R.drawable.icon, "Dr. Its Taca", "Cek kesehatan hewanmu, jangan sampai mereka menuntut! 😾", "30m ago", "Spesialis Dermatologi"),
            ChatMessage(R.drawable.icon, "Dr. Koh Reven Handoko", "Sayangi hewan peliharaanmu seperti pacarmu! 😻", "15m ago", "Spesialis Reproduksi")
        )

        chatAdapter = ChatAdapter(chatList)
        recyclerView.adapter = chatAdapter
    }
}