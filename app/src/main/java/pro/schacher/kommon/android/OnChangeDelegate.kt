package pro.schacher.kommon.android

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <T> Delegates.onChange(
    initialValue: T,
    crossinline onChange: (newValue: T) -> Unit
): ReadWriteProperty<Any?, T> =
    object : ObservableProperty<T>(initialValue) {
        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) =
            if (oldValue != newValue) {
                onChange(newValue)
            } else {
                Unit
            }
    }