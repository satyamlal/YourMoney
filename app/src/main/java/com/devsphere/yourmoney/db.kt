package com.devsphere.yourmoney


import com.devsphere.yourmoney.models.Category
import com.devsphere.yourmoney.models.Expense
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

val config = RealmConfiguration.create(schema = setOf(Expense::class, Category::class))
val db: Realm = Realm.open(config)