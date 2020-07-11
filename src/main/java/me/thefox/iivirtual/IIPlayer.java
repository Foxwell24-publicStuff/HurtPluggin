package me.thefox.iivirtual;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.BrewingStand;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

public class IIPlayer
{
    String uuid, name;
    ArrayList<IIInfo> iiInfos;
    ArrayList<Effect> effects;

    public IIPlayer(String uuid)
    {
        this.uuid = uuid;
        iiInfos = new ArrayList<>();
        effects = new ArrayList<>();
    }

    public String getUUID()
    {
        return uuid;
    }
    public String getName()
    {
        return name;
    }

    public String getIiInfos()
    {
        String ans = "No Illnesses or Injuries";

        if (iiInfos.size() > 0)
        {
            ans = "";
            for (int i = 0; i < iiInfos.size(); i++)
            {
                ans += "[" + iiInfos.get(i).name().toUpperCase() + "]";
            }
        }

        return ans;
    }
    public String getIiInfosRaw()
    {
        if (iiInfos.size() > 0)
        {
            String ans = "";
            for (int i = 0; i < iiInfos.size(); i++)
            {
                ans += iiInfos.get(i).name();
                ans += ",";
            }
            return ans;
        }
        else {
            return "Nothing Wrong Here";
        }

    }

    public void addIiInfo(IIInfo iiInfo)
    {
        iiInfos.add(iiInfo);
    }
    public void addIiInfosRaw(String rawData)
    {
        String[] names = rawData.split(",");

        for (int i = 0; i < names.length; i++)
        {
            if (IIInfo.lookup(names[i]) != null)
            {
                addIiInfo(IIInfo.lookup(names[i]));
            }
        }
    }
    public void addEffect(Effect effect)
    {
        effects.add(effect);
    }
    public void doEffects()
    {
        ArrayList<Effect> effectsToRemove = new ArrayList<>();
        for (int i = 0; i < effects.size(); i++)
        {
            if (effects.get(i).stillActive())
            {
                if (effects.get(i).GetType().equals(IIInfo.Blindness)){effectBlindness();}
                else if (effects.get(i).GetType().equals(IIInfo.Broken_Back)){effectBroken_Back();}
                else if (effects.get(i).GetType().equals(IIInfo.Broken_LeftArm)){effectBroken_LeftArm();}
                else if (effects.get(i).GetType().equals(IIInfo.Broken_Leg)){effectBroken_Leg();}
                else if (effects.get(i).GetType().equals(IIInfo.Broken_RightArm)){effectBroken_RightArm();}
                else if (effects.get(i).GetType().equals(IIInfo.Concussion)){effectConcussion();}
                else if (effects.get(i).GetType().equals(IIInfo.Headache)){effectHeadache();}
                else if (effects.get(i).GetType().equals(IIInfo.Legless)){effectLegless();}
                else if (effects.get(i).GetType().equals(IIInfo.Maimed)){effectMaimed();}
                else if (effects.get(i).GetType().equals(IIInfo.Missing_LeftArm)){effectMissing_LeftArm();}
                else if (effects.get(i).GetType().equals(IIInfo.Missing_RightArm)){effectMissing_RightArm();}
                else if (effects.get(i).GetType().equals(IIInfo.One_Legged)){effectOne_Legged();}
                else if (effects.get(i).GetType().equals(IIInfo.Temporary_Blindness)){effectTemporary_Blindness();}
                else {Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding effect]");}
            }
            else {
                effectsToRemove.add(effects.get(i));
            }
            for (int j = 0; j < effectsToRemove.size(); j++)
            {

            }
        }
    }

    private void effectBlindness()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            Bukkit.getPlayer(uuid).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5, 1));
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
    private void effectBroken_Back()
    {

    }
    private void effectBroken_LeftArm()
    {
        IIVirtual.dropHand(uuid);
    }
    private void effectBroken_RightArm()
    {
        IIVirtual.dropHand(uuid);
    }
    private void effectBroken_Leg()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            float baseSpeed = Bukkit.getPlayer(uuid).getWalkSpeed();
            Bukkit.getPlayer(uuid).setWalkSpeed(baseSpeed * 0.5f);
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
    private void effectConcussion()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            Bukkit.getPlayer(uuid).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5, 1));
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
    private void effectHeadache()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            Bukkit.getPlayer(uuid).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5, 1));
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
    private void effectLegless()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            float baseSpeed = Bukkit.getPlayer(uuid).getWalkSpeed();
            Bukkit.getPlayer(uuid).setWalkSpeed(baseSpeed * 0.1f);
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
    private void effectMaimed()
    {

    }
    private void effectMissing_LeftArm()
    {
        IIVirtual.dropHand(uuid);
    }
    private void effectMissing_RightArm()
    {
        IIVirtual.dropHand(uuid);
    }
    private void effectOne_Legged()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            float baseSpeed = Bukkit.getPlayer(uuid).getWalkSpeed();
            Bukkit.getPlayer(uuid).setWalkSpeed(baseSpeed * 0.5f);
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
    private void effectTemporary_Blindness()
    {
        if (Bukkit.getPlayer(uuid) != null)
        {
            Bukkit.getPlayer(uuid).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5, 1));
        }
        else {
            Commands.console.sendMessage(ChatColor.RED + "Something went wrong [finding player to effect]");
        }
    }
}
