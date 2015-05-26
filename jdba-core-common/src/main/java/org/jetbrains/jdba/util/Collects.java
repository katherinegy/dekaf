package org.jetbrains.jdba.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;



/**
 * @author Leonid Bushuev from JetBrains
 **/
public abstract class Collects {



  @NotNull
  public static String arrayToString(final Object[] array, final String delimiter) {
    if (array == null) return "";
    int n = array.length;
    switch (n) {
      case 0:
        return "";
      case 1:
        return array[0].toString();
      default:
        StringBuilder b = new StringBuilder();
        b.append(array[0].toString());
        for (int i = 1; i < n; i++) b.append(delimiter).append(array[i]);
        return b.toString();
    }
  }

  @NotNull
  public static <T> T[][] splitArrayPer(@NotNull final T[] array, final int limitPerPack) {
    final int n = array.length;
    final Class<? extends Object[]> arrayType = array.getClass();

    int m = n / limitPerPack,
        r = n % limitPerPack;
    if (r > 0) m++;

    //noinspection unchecked
    T[][] packs = (T[][]) Array.newInstance(arrayType, m);

    int k = 0;
    for (int i = 0; i < m && k < n; i++, k+=limitPerPack) {
      int end = Math.min(k + limitPerPack, n);
      packs[i] = Arrays.copyOfRange(array, k, end);
    }

    return packs;
  }


  @NotNull
  public static String collectionToString(@Nullable final Iterable collection,
                                          @Nullable final String delimiter) {
    return collectionToString(collection, delimiter, null, null, null);
  }



  @NotNull
  public static String collectionToString(@Nullable final Iterable collection,
                                          @Nullable final String delimiter,
                                          @Nullable final String prefix,
                                          @Nullable final String suffix,
                                          @Nullable final String empty) {
    if (collection == null) {
      return empty == null ? "" : empty;
    }

    StringBuilder b = new StringBuilder();
    Iterator it = collection.iterator();
    while (it.hasNext()) {
      if (b.length() == 0) {
        if (prefix != null) b.append(prefix);
      }
      else {
        if (delimiter != null) b.append(delimiter);
      }

      b.append(it.next());
    }

    if (b.length() > 0) {
      if (suffix != null) b.append(suffix);
    }
    else {
      if (empty != null) b.append(empty);
    }

    return b.toString();
  }


}