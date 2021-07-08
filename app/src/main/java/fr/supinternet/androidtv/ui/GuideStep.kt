package fr.supinternet.androidtv.ui

import android.os.Bundle
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.leanback.widget.GuidanceStylist
import androidx.leanback.widget.GuidedAction

class GuideStep : GuidedStepSupportFragment() {
    override fun onCreateGuidance(savedInstanceState: Bundle?): GuidanceStylist.Guidance {
        return GuidanceStylist.Guidance("Ma question", "Des détails", "Question 1", null)
    }

    override fun onCreateActions(actions: MutableList<GuidedAction>, savedInstanceState: Bundle?) {
        super.onCreateActions(actions, savedInstanceState)

        val action1 = GuidedAction.Builder(requireContext()).id(0).title("Oui").build()
        actions.add(action1)

        val subActions: ArrayList<GuidedAction> = ArrayList()
        subActions.add(GuidedAction.Builder(requireContext()).id(3).title("Peut-être")
            .build())
        subActions.add(GuidedAction.Builder(requireContext()).id(4).title("Certainement")
            .build())

        val action2 = GuidedAction.Builder(requireContext()).id(1).title("J'hésite")
            .description("Clickez pour ouvrir")
            .subActions(subActions)
            .build()
        actions.add(action2)

        val action3 = GuidedAction.Builder(requireContext()).id(2).title("Non").build()
        actions.add(action3)
    }

    override fun onSubGuidedActionClicked(action: GuidedAction?): Boolean {
        if (action != null) {
            findActionById(action.id).description = "Choisissez"
            val position = findActionPositionById(action.id)
            notifyActionChanged(position)
        }

        return super.onSubGuidedActionClicked(action)
    }

}