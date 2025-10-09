class Solution {
    public long minTime(int[] skill, int[] mana) {
        long sumSkill = 0;
        for (int s : skill) sumSkill += s;

        // prevWizardDone = end time after last wizard for the already scheduled potions
        long prevWizardDone = sumSkill * (long) mana[0];

        for (int j = 1; j < mana.length; ++j) {
            long prevPotionDone = prevWizardDone;
            // iterate wizards from second-last down to first
            for (int i = skill.length - 2; i >= 0; --i) {
                // subtract the contribution of wizard i+1 for previous potion
                prevPotionDone -= (long) skill[i + 1] * (long) mana[j - 1];
                // choose the later of:
                //  - prevPotionDone (earliest we can start this wizard for potion j coming from next wizard)
                //  - prevWizardDone - time needed by this wizard for potion j (so this wizard won't overlap previous schedule)
                prevWizardDone = Math.max(prevPotionDone, prevWizardDone - (long) skill[i] * (long) mana[j]);
            }
            // after fixing starts for all wizards for potion j, add total processing time for potion j across all wizards
            prevWizardDone += sumSkill * (long) mana[j];
        }

        return prevWizardDone;
    }
}
