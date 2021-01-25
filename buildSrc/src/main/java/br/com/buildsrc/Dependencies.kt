object Version {

    const val kotlin = "1.4.21"
    const val gradle = "4.1.1"
    const val appCompat = "1.2.0"
    const val coreKtx = "1.3.2"
    const val constraintLayout = "2.0.4"
    const val swiperefresh = "1.1.0"
    const val material = "1.2.1"
    const val interceptor = "4.8.1"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.2.0"
    const val koin = "2.1.5"
    const val picasso = "2.71828"
    const val sharedPreference = "1.1.1"
    const val navigation = "2.3.2"

    //test
    const val jUnit = "4.13.1"
    const val robolectric = "4.4"
    const val espresso = "3.3.0"
    const val mockk = "1.10.3-jdk8"
    const val testCore = "1.3.0"
    const val archTest = "2.1.0"
    const val jUnitExt = "1.1.1"
    const val truth = "1.1"
    const val coroutines = "1.4.2"
    const val mockito = "2.2.0"
}

object Libs {

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
    const val sharedPreference = "androidx.preference:preference-ktx:${Version.sharedPreference}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Version.interceptor}"
    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swiperefresh}"
    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${Version.lifecycle}"
    const val coreKtx =  "androidx.core:core-ktx:${Version.coreKtx}"
    const val material = "com.google.android.material:material:${Version.material}"

    //Layout
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    //Networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

    //Koin
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"
    const val koinScope  = "org.koin:koin-androidx-scope:${Version.koin}"
    const val koin  = "org.koin:koin-android:${Version.koin}"
}

object LibsTest{
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val robolectric = "org.robolectric:robolectric:${Version.robolectric}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Version.espresso}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
    const val testCoreKtx = "androidx.test:core-ktx:${Version.testCore}"
    const val koinTest = "org.koin:koin-test:${Version.koin}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    const val archTest = "androidx.arch.core:core-testing:${Version.archTest}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val jUnitExt = "androidx.test.ext:junit:${Version.jUnitExt}"
    const val truth = "com.google.truth:truth:${Version.truth}"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockito}"
    const val fragmentTest2 = "androidx.fragment:fragment-testing:1.1.0-alpha05"
    const val fragmentTest = "androidx.navigation:navigation-testing:${Version.navigation}"
}