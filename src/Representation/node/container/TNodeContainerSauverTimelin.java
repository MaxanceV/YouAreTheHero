package Representation.node.container;

import java.security.KeyStore.Entry;

import Representation.node.ANode;
import Representation.node.ANodeInner;
import Representation.node.TNodeChance;
import Representation.node.TNodeDecision;
import Representation.node.TNodeFight;
import Representation.node.TNodeLevelUp;
import Representation.node.TNodeTerminal;
import Univers.TPersonnage;
import Univers.Enum.ERace;
import Univers.classe.AClasseGuerrier;
import Univers.classe.TClasseArchimage;
import Univers.classe.TClasseObstacle;


public class TNodeContainerSauverTimelin extends ANodeContainer {


	private final String INTRO_TIMELIN = "intro.timelin";
	private final String SALLE_TAVERNE = "salle.taverne";
	private final String DISCUSSION_CHASSEUR = "discussion.chasseur";
	private final String GROS_BRAS = "gros.bras";
	private final String PETIT_BRAS = "petit_bras";
	private final String DISCUSSION_ELFES = "discussion.elfes";
	private final String ELFES_RATE = "elfes.rate";
	private final String ELFES_REUSSI = "elfes.reussi";
	private final String SORTIE_VILLE = "sortie.ville";
	private final String COMBAT_1_GOBELIN = "combat.1.gobelin";
	private final String DEFAITE_COMBAT = "defaite.combat";
	private final String VICTOIRE_COMBAT_1 = "victoire.combat.1";
	private final String MONTEE_RANG = "montee.rang";
	private final String REPAIRE_GOBELINS = "repaire.gobelins";
	private final String DIRE_RIEN = "dire.rien";
	private final String DIRE_DRAGON = "dire.dragon";
	private final String DIRE_DUEL = "dire.duel";
	private final String COMBAT_2_DRAGON = "combat.2.dragon";
	private final String COMBAT_3_CHAMAN = "combat.3.chaman";
	private final String VICTOIRE_COMBAT_2 = "victoire.combat.2";
	private final String VICTOIRE_COMBAT_3 = "victoire.combat.3";

	public TNodeContainerSauverTimelin() {
	
		TNodeDecision intro = addNodeDecision(INTRO_TIMELIN,"Bienvenue à Timelin ! Le ciel rayonne et votre visage aussi : vous voilà enfin parti à l'aventure ! "
				+ "Néanmoins, la fierté que vous éprouvez ne semble pas partagée par les habitants de la ville. Les passants sont maussades et rendent la journée tout aussi morose que leurs visages. "
				+ "Mais non pas sans raison : les temps sont durs pour la ville de Timelin. Une odeur de brûlé dirige d'abord votre nez, puis vos yeux vers les ruines d'une maison, aujourd'hui en cendres"
				+ ". Vos oreilles, quant à elle, entendent les échos d'une conversation de deux autochtones contemplant les ruines : 'Il paraît que ce sont des gobelins qui ont fait ça..."
				+ " - Ah oui ? Mais comment ont-ils pu brûler une maison aussi grande aussi vite ? - Et bien, selon certaines rumeurs, ils auraient avec eux un dragon...'. Vous vous retenez de sauter "
				+ "de joie alors que vous entendez ces mots. Cette quête est juste ce qu'il vous faut ! Sauver le village de Timelin de cette menace gobeline serait un bon moyen de propulser "
				+ "votre carrière de héros ! Vous prenez votre temps pour réfléchir à un plan d'action. Vous remarquez plus loin dans l'avenue une taverne, peut-être pourriez-vous y trouver "
				+ "plus d'informations sur cette menace ? Mais vous pouvez aussi décider de revenir sur vos pas et sortir de la ville pour aller affronter ces gobelins tout de suite ! ",null);
		
		TNodeDecision taverne = addNodeDecision(SALLE_TAVERNE,"Vous marchez vers la taverne et en ouvrez la porte avec confiance. Instantanément, une odeur âpre, mélange d'alcool et de sueur, vous "
				+ "happe dans l'atmosphère de la taverne. Mais il en faut plus pour vous faire rebrousser chemin et vous entrez lentement dans la pièce. La taverne consiste en une grande salle "
				+ "où au fond, accoudé au comptoir, on peut voir un barman. Le reste de la salle est rempli de petites tables rondes où mangent et boivent une population assez hétérogène, "
				+ "plus ou moins recommendable, selon les tablées. Deux tables en particulier attirent votre attention. A votre droite, près d'une fenêtre, un individu vêtu de peaux sirote une bière. "
				+ "A ses côtés se trouve une arbalète et l'on peut voir un sac à ses pieds, dont dépasse des collets. Un chasseur, qui doit surement en savoir un rayon sur les monstres de la région. "
				+ "Dans un style tout à fait différent, une autre table accueille 3 elfes encapuchonnés dans de longues robes. Ils parlent bas mais les runes sur leurs vêtements trahit leur profession : "
				+ "des magiciens. Peut-être s'y connaissent-ils en dragons ? ","Aller à la taverne");
		TNodeChance   chasseur = addNodeChance(DISCUSSION_CHASSEUR,"Le chasseur vous regarde d'un air méfiant alors que vous vous asseyez à sa table. Après que vous lui ayez exposer votre quête "
				+ "et la manière dont il pourrait vous aider - à savoir en vous donnant des informations sur les gobelins- il réfléchit quelques instants avant de vous lancer un regard espiègle. "
				+ "'Je peux vous donner ces informations, mais il va falloir me prouver que vous les méritez. Un petit bras de fer, ça vous dit ? '. Il retrousse la manche de son bras droit qu'il "
				+ "pose sur la table, la main ouverte vers vous. Vous n'avez d'autre choix que de répondre positivement à son défi. Voyons si vous avez la force de le vaincre..."
				+ "","Aller parler au chasseur");
		TNodeDecision grosbras = addNodeDecision(GROS_BRAS,"Vous êtes dans un bon jour et vous le faites sentir au chasseur. Malgré sa force et sa stature intimidante, vous parvenez à remporter le bras "
				+ "de fer avec le chasseur. Il se secoue le bras, un peu surpris d'avoir perdu. 'Pas mal, pas mal. Un deal est un deal. Je vais vous dire tout ce que je sais sur les gobelins : "
				+ "ces petites créatures vertes sont très nombreuses mais elles ne sont pas très intelligentes. Cela signifie qu'ils sont aussi facilement influencables. S'ils se répétent longtemps "
				+ "quelque chose, ils risquent de finir par y croire. Par exemple, s'ils se disent qu'ils sont les rois du monde, ou bien s'ils s'imaginent qu'ils ont avec eux un dragon...'. Ravi "
				+ "d'avoir appris quelque chose d'utile, vous décidez qu'il est temps de sortir de la ville et partir à l'assaut des gobelins. ","Gagner le  bras de fer");
		TNodeDecision petitbras = addNodeDecision(PETIT_BRAS,"Malgré vos efforts, le chasseur prend peu à peu le dessus. Vous luttez, mais la vie dans la nature a renforcé son endurance et enduré "
				+ "sa force. Votre bras touche la table et le chasseur vous lance un grand sourire, très fier de sa victoire. Penaud, vous décidez qu'il est temps de sortir de la ville et partir "
				+ "à l'assaut des gobelins. ","Perdre le bras de fer");
		TNodeChance   elfes =  addNodeChance(DISCUSSION_ELFES,"Les elfes vous regardent non sans étonnement vous asseoir à leur table. L'un d'eux s'adresse à vous et vous réalisez soudainement, bien "
				+ "que ce ne soit finalement pas si surprenant, que les elfes parlent en elfique. Mais peut-être vos précédents voyages vous ont-ils menés à découvrir cette belle langue. Alors, "
				+ "parlez-vous elfique ?","Aller parler aux elfes");
		TNodeDecision elfesrate = addNodeDecision(ELFES_RATE,"Hum...vous souriez, embarrassé, en vous rendant compte que vous ne parlez pas le moindre mot d'elfique. Les elfes ont l'air tout aussi "
				+ "déconcertés que vous et ne disent plus un mot lorsque vous vous levez et quittez la taverne. Penaud, vous décidez qu'il est temps de sortir de la ville et partir "
				+ "à l'assaut des gobelins. ","Vous ne parlez pas elfique.");
		TNodeDecision elfesreussi = addNodeDecision(ELFES_REUSSI,"Vous réfléchissez un moment, puis votre mémoire vous revient. Vous lui répondez que vous allez très bien et leur demandez à leur tour "
				+ "comment ils se portent. Vous dirigez alors la discussion sur le dragon dont vous avez entendu parler et les elfes vous disent la chose suivante : 'Ce serait très étonnant que les "
				+ "gobelins aient vraiment un dragon à leur service. Peu de choses pourraient obliger une créature si puissante à servir des gobelins. Et les dragons ne détruisent pas simplement "
				+ "des maisons, ni même des villages. Leur mesure de la destruction est plutôt de l'ordre des villes et capitales. Non, peu importe ce que ces gobelins prétendent, ils n'ont "
				+ "surement pas de dragon à leurs côtés.'. Ravi d'avoir appris quelque chose d'utile, vous décidez qu'il est temps de sortir de la ville et partir à l'assaut des gobelins.","Vous parlez"
				+ " elfique");
		TNodeDecision sortieville = addNodeDecision(SORTIE_VILLE,"Une légère brise souffle agréablement en dehors de la ville. Le soleil est toujours haut dans le ciel et éclaire les grandes plaines."
				+ "La parfaite platitude de ces grandes étendues vertes est rendue imparfaite par plusieurs bosquets, allant du simple couple de chênes à une petite forêt. Mais votre contemplation est"
				+ "vite interrompue par des cris stridents. Plus loin sur la route principale, une petite créature verte pourchasse un paysan et le pique en ricanant à l'aide d'un pieu "
				+ "grossièrement taillé. Ces longues oreilles et ces yeux rouges ne laissent aucun doute : c'est un gobelin ! Héros que vous êtes, vous vous lancez à la rescousse du pauvre fermier. "
				,"Sortir de la ville");
		
		TPersonnage Gobelin = new TPersonnage("Gabin le gobelin", new AClasseGuerrier(), ERace.GOBELIN);
		Gobelin.setPointVie(10);
		Gobelin.setClasseArmur(12);
		TNodeFight    combat1 = addNodeFight(COMBAT_1_GOBELIN,"Alors que vous vous approchez, le gobelin se tourne vers vous. Ses petits yeux méchants s'illuminent d'encore plus de malice et ne prêtent"
				+ "plus aucune attention au paysan qui s'échappe en haletant. Le gobelin sourit...puis se jette sur vous ! ","Affronter le gobelin",Gobelin);
		
		TNodeTerminal defaitecombat = addNodeTerminal(DEFAITE_COMBAT,"Une affreuse sensation de vide et d'engourdi envahit votre corps alors que vous encaissez cet ultime coup. Votre souffle\"\r\n"
				+ "				+ \"est coupé et alors que vous tentez encore de comprendre ce qui vous arrive, vous tombez à genoux. Un dernier soupir fuit votre corps et vos yeux se ferment..."
				,"Continuer");
		TNodeLevelUp monteerang = addNodeLevelUp(MONTEE_RANG,"Gagner ce combat vous a offert beaucoup d'expériences sur vos techniques de combat. Vous sentez un souffle d'inspiration"
				+ "qui envahit votre corps. C'est le moment de monter de niveau !","Monter de niveau");
		// Vous passez de "classe actuelle" à "classe évoluée" ! Félicitations. 
		TNodeDecision victoirecombat1 = addNodeDecision(VICTOIRE_COMBAT_1,"Le gobelin, vaincu, s'effondre devant vous. Quel beau combat ! Tandis que vous reprenez votre souffle et appréciez la nouvelle "
				+ " force qui réside en vous, le paysan que vous venez de sauver s'approche de vous : 'Oh merci ! Je ne sais pas ce que j'aurai fait sans vous, milles merci aventurier ! Si jamais vous"
				+ "voulez vous mesurer au reste de leur tribu, je vous conseille d'aller vers l'est. C'est là que se trouve leur repaire. Bonne chance, et merci encore !'. Fier d'avoir sauvé un"
				+ "si brave homme, vous regarder la direction qu'il pointe. Un sentier semble sillonner parmi les plaines jusqu'à une petit forêt, assez opaque vue d'ici. Voilà votre prochain objectif."
				,"Continuer");
		
		
		TNodeDecision repairegobelins = addNodeDecision(REPAIRE_GOBELINS,"Après avoir suivi le sentier un moment, vous entrez dans la forêt. L'air est lourd et les oiseaux ne chantent pas. Un léger "
				+ "frisson vous parcourt, mais vous n'êtes pas allé aussi loin pour vous arrêter maintenant. Vous chassez ces angoisses et resserez votre poigne sur votre arme. Une odeur nauséabonde "
				+ "très semblable à celle du gobelin que vous avez affronté tout à l'heure vous emplit les narines. Le sentier fait un tournant et vous apercevez soudain, droit devant vous, "
				+ "l'entrée d'une grotte. Mais ce n'est pas cette entrée qui vous surprend, c'est plutôt la horde de gobelins qui l'entoure. Tous vous fixent, un grand sourire aux lèvres. Face à un tel"
				+ "nombre, ni la fuite ni un combat ouvert ne semblent une bonne idée. Mais vous n'avez pas le temps de décider d'un plan d'action car au milieu de la troupe, bousculant ses collègues, "
				+ "un gobelin portant une étrange coiffe et un bâton à l'air vaguement magique se fraie un passage vers vous. Il parvient finalement à sortir de la foule et s'avance de quelques pas. "
				+ "'Hum hum. Bonjour monsieur ! Tu es pris au piège, monsieur ! Tu sens le sang de gobelin, tu paieras pour ce que tu as fait à Gabin !'. Le chaman s'approche vers vous, mais le temps"
				+ "qu'il couvre cette distance vous permet de dire quelque chose :","Suivre le sentier vers le repaire des gobelins.");
		
		TNodeDecision direrien = addNodeDecision(DIRE_RIEN, "Vous ne dites rien et laissez le chaman s'approcher de vous. Assez étrangement, les autres gobelins ne semblent pas le suivre. Vous levez "
				+ "votre arme et vous préparez au combat. ","Ne rien dire.");
		TNodeDecision diredragon = addNodeDecision(DIRE_DRAGON,"Vous hélez le chaman alors qu'il s'avance vers vous : 'Si je gagne un duel contre votre dragon, vous partirez d'ici et laisserez"
				+ " Timelin tranquille ?'. Le chaman réfléchit un instant, puis un grand sourire fend son petit visage. Il acquiesce. Les gobelins forment une haie vers l'entrée de la grotte et leurs "
				+ "yeux rouges pétillent d'impatience. Vous levez votre arme et entrez prudemment dans la grotte, prêt au combat.","Proposer d'affronter le dragon.");
		TNodeDecision direduel = addNodeDecision(DIRE_DUEL,"Vous hélez le chaman alors qu'il s'avance vers vous : 'Si je gagne un duel contre toi, vous partirez d'ici et laisserez Timelin tranquille ?'."
				+ " Le chaman réfléchit un instant, vous regarde de haut en bas, puis acquiesce. Vous levez votre arme et vous préparez au combat.","Proposer d'affronter le chaman en duel.");
		

		TPersonnage DragonFarine = new TPersonnage("Sacs de farine mal peints", new TClasseObstacle(), ERace.OBSTACLE);
		DragonFarine.setPointVie(20);
		DragonFarine.setClasseArmur(0);
		TNodeFight    combat3 = addNodeFight(COMBAT_2_DRAGON,"Vous continuez dans la grotte mais n'entendez ni rugissement ni ne subissez de brûlure au 3ème degré. Où est donc ce fameux dragon ? "
				+ "Mais en pensant ces mots, vous voyez une forme sombre se dessiner au fond de la grotte. Aucun mouvement, et pourtant c'est bien les dimensions d'un dragon. Vous voyez même un oeil,"
				+ "des écailles, des griffes...mais vous reconnaissez bien vite que ce n'est qu'une couche de peinture appliquée sur de gros sacs de jute. Vous soupirez de soulagement et vous "
				+ "apprêtez à massacrer ces pauvres sacs.","Affronter le dragon",DragonFarine);
		
		TPersonnage Chaman = new TPersonnage("Toutankharton le chaman", new TClasseArchimage(), ERace.GOBELIN);
		DragonFarine.setPointVie(25);
		DragonFarine.setClasseArmur(14);
		TNodeFight 	  combat2 = addNodeFight(COMBAT_3_CHAMAN,"Vous voyez des tatouages tribaux sur le visage du chaman qui semblent s'illuminer, comme traversés par une puissance magique. Ses yeux, "
				+ "au contraire, sont imperturbablement fixés sur vous. Il s'arrête, lève son bâton, et le combat commence. ","Affronter le chaman",Chaman);
		
		TNodeTerminal victoire2 = addNodeTerminal(VICTOIRE_COMBAT_2,"Vous découpez rapidement ce monstre fantaisiste et sortez de la grotte, triomphant. Les gobelins vous regardent avec horreur, "
				+ "terrifiés par votre puissance. Avant même que vous ne commenciez à parler, tous détalent sans demander leur reste. Vous contemplez la scène et une immense fierté vous envahit. "
				+ "Vous êtes le vainqueur du dragon ! Vous êtes le sauveur de Timelin ! Et mieux que tout ça, vous êtes un vrai héros.","Continuer");
		TNodeTerminal victoire3 = addNodeTerminal(VICTOIRE_COMBAT_3,"Après un combat acharné contre ce gobelin chaman, vous finissez par triompher. Les gobelins vous regardent avec horreur, "
				+ "terrifiés par votre puissance. Avant même que vous ne commenciez à parler, tous détalent sans demander leur reste. Vous contemplez la scène et une immense fierté vous envahit."
				+ "Vous êtes le vainqueur du dragon ! Vous êtes le sauveur de Timelin ! Et mieux que tout ça, vous êtes un vrai héros.","Continuer");
		
		intro.setChoix(new ANode[]{taverne,sortieville});
		taverne.setChoix(new ANode[]{chasseur,elfes});
		chasseur.setChoix(new ANode[]{grosbras,petitbras});
		grosbras.setChoix(new ANode[]{sortieville});
		petitbras.setChoix(new ANode[]{sortieville});
		elfes.setChoix(new ANode[]{elfesrate,elfesreussi});
		elfesrate.setChoix(new ANode[]{sortieville});
		elfesreussi.setChoix(new ANode[]{sortieville});
		sortieville.setChoix(new ANode[] {combat1});
		combat1.setChoix(new ANode[]{monteerang,defaitecombat});
		monteerang.setChoix(new ANode[]{victoirecombat1});
		victoirecombat1.setChoix(new ANode[]{repairegobelins});
		repairegobelins.setChoix(new ANode[]{direrien,direduel,diredragon});
		direrien.setChoix(new ANode[]{combat2});
		direduel.setChoix(new ANode[]{combat2});
		diredragon.setChoix(new ANode[]{combat3});
		combat2.setChoix(new ANode[]{victoire2,defaitecombat});
		combat3.setChoix(new ANode[]{victoire3,defaitecombat});
		
		for(java.util.Map.Entry<String, ANode> entry : getNodesOfTheGame().entrySet()) {
			String key = entry.getKey();
		    ANode value = entry.getValue();
		    if(value instanceof ANodeInner) {
		    	if(((ANodeInner) value).getChoix() == null) {
			    	System.out.println("WARNING : le noeuds " + key + " n'a pas de suite");	
		    	}
		    }
		}
		
		
	}
		

	@Override
	public ANodeInner getDefaultStartNode() {
		return (ANodeInner) getNodeFromId(INTRO_TIMELIN);
	}
		
}