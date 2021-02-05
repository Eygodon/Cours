#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#include "myassert.h"

#include "Voiture.h"
#include "Collection.h"

static void usage(const char *exe)
{
    fprintf(stdout, "usage %s [full]\n", exe);
    exit(EXIT_FAILURE);
}


/*=================================================================*
 * Manipulation de voitures
 *=================================================================*/

// on ne gère pas plus finement ici
#define MAX_LEN 1000

void main()
{
  

    Voiture v1, v2, v3;
    Collection c1, c2;

    const char *tmp[2] = {"1234 AE 75", "VH 529 FE"};
    v1 = voi_Create("Trombine", 2005, 34587, 2, tmp);
    v2 = voi_CpyCreate(v1);
    v3 = voi_CpyCreate(v1);
    c1 = coll_createEmpty ();
	c2 = coll_createCpy (c2);
	coll_destroy (c1);
	coll_empty (c2);
}
