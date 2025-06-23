package com.arrtish.godemperor.the_vault_android.appdb.character

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.arrtish.godemperor.the_vault_android.appdb.user.User


@Entity(
    tableName = "basecharacter",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["userId"],
        childColumns = ["userOwnerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class BaseCharacterEntity(
    @PrimaryKey(autoGenerate = true) val characterId: Int = 0,
    // Basic Info
    val name: String,
    val race: String,
    val charClass: String,
    val level: Int,
    val background: String,
    val alignment: String,
//    val experiencePoints: Int,
    val userOwnerId: Int,

    // Ability Scores & Mods
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,

    // Derived Stats
    val proficiencyBonus: Int,
    val armorClass: Int,
    val initiativeBonus: Int,
    val speed: Int,
    val maxHitPoints: Int,
    val currentHitPoints: Int,
    val temporaryHitPoints: Int,
    val hitDice: String, // e.g., "1d8,2d6"

    // Saving Throws (proficient or not)
    val saveStr: Boolean,
    val saveDex: Boolean,
    val saveCon: Boolean,
    val saveInt: Boolean,
    val saveWis: Boolean,
    val saveCha: Boolean,

    // Passive Perception
    val passivePerception: Int,
    val passiveInsight: Int,

    // Skills (proficient or not)
    val skillAcrobatics: Char,
    val skillAnimalHandling: Char,
    val skillArcana: Char,
    val skillAthletics: Char,
    val skillDeception: Char,
    val skillHistory: Char,
    val skillInsight: Char,
    val skillIntimidation: Char,
    val skillInvestigation: Char,
    val skillMedicine: Char,
    val skillNature: Char,
    val skillPerception: Char,
    val skillPerformance: Char,
    val skillPersuasion: Char,
    val skillReligion: Char,
    val skillSleightOfHand: Char,
    val skillStealth: Char,
    val skillSurvival: Char,

    // Combat & Attacks
//    val attacksAndSpellcasting: String, // JSON or serialized detail
    val meleeAttackBonus: Int,
    val rangedAttackBonus: Int,
    val spellAttackBonus: Int,
    val SpellSaveDC: Int,
    val isSpellCaster: Boolean,
    // Resources & Features
//    val featuresAndTraits: String,
//    val equipment: String,
    val otherProficienciesAndLanguages: String,

//    // Personality & Roleplay
//    val personalityTraits: String,
//    val ideals: String,
//    val bonds: String,
//    val flaws: String,
//    val alliesOrganizations: String,
//    val backstory: String,

    // Currency
    val copper: Int,
    val silver: Int,
//    val electrum: Int,
    val gold: Int,
    val platinum: Int
)