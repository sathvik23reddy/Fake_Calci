package com.example.fakecalci

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class ContactsActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        setContent {
            val contacts: ArrayList<ContactModel> = ArrayList()
            val cursor: Cursor? = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME+" ASC"
            )
            if (cursor != null && cursor.count > 0) {
                val contactIdIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
                val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                while (cursor.moveToNext()) {
                    val contactId = cursor.getString(contactIdIndex)
                    val number: String = cursor.getString(numberIndex)
                    val name: String = cursor.getString(nameIndex)
                    contacts.add(ContactModel(contactId, number, name))
                }
                cursor.close()
            }
            util(contacts)
        }



    }
    @Composable
    private fun util(myData: ArrayList<ContactModel>) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp))
            LazyColumn {
                items(myData) { item ->
                    listItem(item = item)
                }
            }
        }
        
    }

    @Composable
    private fun listItem(item:ContactModel){
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("number", item.number)
            context.startActivity(intent)
            finish()
        }) {
            Column {
                Text(text = item.name , textAlign = TextAlign.Start)
                Text(text = item.number)
            }

        }
        Spacer(modifier = Modifier.height(9.dp))
    }
}