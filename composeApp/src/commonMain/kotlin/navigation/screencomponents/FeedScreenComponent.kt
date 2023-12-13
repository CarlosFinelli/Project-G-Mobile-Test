package navigation.screencomponents

import com.arkivanov.decompose.ComponentContext

class FeedScreenComponent(
    componentContext: ComponentContext,
    val goToProfileScreen: () -> Unit,
    val goToProjectScreen: () -> Unit
): ComponentContext by componentContext {
    fun onGoToProfileScreen() {
        goToProfileScreen()
    }
    fun onGoToProjectScreen() {
        goToProjectScreen()
    }
}