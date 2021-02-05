#ifndef COLLECTION_H
#define COLLECTION_H

#include <stdbool.h>

#include "Voiture.h"

struct CollectionP;

typedef struct CollectionP* Collection;

typedef const struct CollectionP* const_Collection;

Collection coll_createEmpty ();
Collection coll_createCpy (const_Collection source);

void coll_destroy (Collection toDestroy);
void coll_empty (Collection toEmpty);

#endif
