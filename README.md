# Popis

Pattern **Builder** se používá k sestavení různých konfigurací domů na základě globálního konfiguračního souboru.

Události během činnosti programu jsou generovány náhodně. Pro definování události a možnosti jejího následného zpracování se používá pattern **Chain of Responsibility**. Poté je třeba o této události informovat některé typy zařízení. K tomu se používá pattern **Observer**.

Některá zařízení mají nastavitelná nastavení. Pro obnovení jejich základní konfigurace nebo uložení aktuálního nastavení pro pozdější použití se používá pattern **Snapshot**.

Uživatel může určit, které statistiky ho zajímají a které ne. Každé zařízení generuje kompletní statistiku. K vytvoření dílčí statistiky se používá pattern **Visitor**.
