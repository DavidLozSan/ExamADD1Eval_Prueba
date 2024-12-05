package edu.iesam.examaad1eval.features.ex1.data.local.xml

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(private val context: Context) {
    val fileName = "db-exam"

    val sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    val gson = Gson()

    fun saveAllUsers(users: List<User>) {
        val usersJson = gson.toJson(users)
        sharedPreferences.edit().putString("users", usersJson).apply()
    }

    fun getUsers(): List<User> {
        val usersJson = sharedPreferences.getString("users", null) ?: return emptyList()
        val type = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(usersJson, type) ?: emptyList()
    }

    fun saveAllItems(items: List<Item>) {
        val itemsJson = gson.toJson(items)
        sharedPreferences.edit().putString("items", itemsJson).apply()
    }

    fun getItems(): List<Item> {
        val itemsJson = sharedPreferences.getString("items", null) ?: return emptyList()
        val type = object : TypeToken<List<Item>>() {}.type
        return gson.fromJson(itemsJson, type) ?: emptyList()
    }

    fun saveAllServices(services: List<Services>) {
        val servicesJson = gson.toJson(services)
        sharedPreferences.edit().putString("services", servicesJson).apply()
    }

    fun getServices(): List<Services> {
        val servicesJson = sharedPreferences.getString("services", null) ?: return emptyList()
        val type = object : TypeToken<List<Services>>() {}.type
        return gson.fromJson(servicesJson, type) ?: emptyList()
    }
}