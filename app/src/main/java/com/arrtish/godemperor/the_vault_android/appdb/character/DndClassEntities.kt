package com.arrtish.godemperor.the_vault_android.appdb.character


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// ============================
// Artificer


// ============================
// Barbarian
@Entity(
    tableName = "barbarian_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class BarbarianEntity(
    @PrimaryKey val characterId: Int,
    val rageCount: Int,
    val rageDamageBonus: Int
)


// ============================
// Bard
@Entity(
    tableName = "bard_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class BardEntity(
    @PrimaryKey val characterId: Int,
    val inspirationDice: String,
    val inspirationUses: Int
)


// ============================
// Cleric
@Entity(
    tableName = "cleric_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ClericEntity(
    @PrimaryKey val characterId: Int,
    val domain: String,
    val channelDivinityUses: Int
)


// ============================
// Druid
@Entity(
    tableName = "druid_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DruidEntity(
    @PrimaryKey val characterId: Int,
    val wildShapeUses: Int,
    val circle: String
)


// ============================
// Fighter
@Entity(
    tableName = "fighter_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class FighterEntity(
    @PrimaryKey val characterId: Int,
    val fightingStyle: String,
    val secondWindUses: Int
)

// ============================
// Monk
@Entity(
    tableName = "monk_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class MonkEntity(
    @PrimaryKey val characterId: Int,
    val kiPoints: Int,
    val martialArtsDie: String
)

// ============================
// Paladin
@Entity(
    tableName = "paladin_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PaladinEntity(
    @PrimaryKey val characterId: Int,
    val oath: String,
    val layOnHandsPoints: Int
)


// ============================
// Ranger
@Entity(
    tableName = "ranger_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RangerEntity(
    @PrimaryKey val characterId: Int,
    val favoredEnemy: String,
    val favoredTerrain: String
)


// ============================
// Rogue
@Entity(
    tableName = "rogue_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RogueEntity(
    @PrimaryKey val characterId: Int,
    val expertiseCount: Int,
    val cunningAction: Boolean
)


// ============================
// Sorcerer
@Entity(
    tableName = "sorcerer_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class SorcererEntity(
    @PrimaryKey val characterId: Int,
    val origin: String,
    val sorceryPoints: Int
)


// ============================
// Warlock
@Entity(
    tableName = "warlock_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class WarlockEntity(
    @PrimaryKey val characterId: Int,
    val patron: String,
    val pactBoons: String
)


// ============================
// Wizard
@Entity(
    tableName = "wizard_details",
    foreignKeys = [ForeignKey(
        entity = BaseCharacterEntity::class,
        parentColumns = ["characterId"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class WizardEntity(
    @PrimaryKey val characterId: Int,
    val spellbook: String, // e.g., JSON string or delimited list of spells
    val preparedSpells: Int
)

